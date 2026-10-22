package org.com.ui;

import org.com.model.*;
import org.com.service.ClienteService;
import org.com.service.ReservaService;
import org.com.service.ServicioService;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.Scanner;

public class MenuConsola {

    private final ClienteService clienteService;
    private final ServicioService servicioService;
    private final ReservaService reservaService;
    private final Scanner scanner;

    public MenuConsola(ClienteService clienteService, ServicioService servicioService, ReservaService reservaService) {
        this.clienteService = clienteService;
        this.servicioService = servicioService;
        this.reservaService = reservaService;
        this.scanner = new Scanner(System.in);
    }

    private void mostrarOpciones() {
        System.out.println("=== GESTIÓN DE RESERVAS ===");
        System.out.println("1. Registrar Cliente");
        System.out.println("2. Registrar Servicio");
        System.out.println("3. Crear Reserva");
        System.out.println("4. Buscar Reserva por código");
        System.out.println("5. Modificar Reserva");
        System.out.println("6. Cancelar Reserva");
        System.out.println("7. Procesar siguiente Reserva (Atender Prioridad)");
        System.out.println("8. Mostrar Agenda (Ordenada por Fecha)");
        System.out.println("9. Salir");
    }

    private void registrarCliente() {
        System.out.println("--- REGISTRAR CLIENTE ---");
        String id = leerTexto("ID del cliente: ");
        String nombre = leerTexto("Nombre completo: ");
        String email = leerTexto("Email: ");
        Cliente cliente = new Cliente(id, nombre, email);
        if (clienteService.registrarCliente(cliente)) {
            System.out.println("Cliente registrado con éxito.");
        } else {
            System.out.println("El cliente ya está registrado.");
        }
    }

    private void registrarServicio() {
        System.out.println("--- REGISTRAR SERVICIO ---");
        String nombre = leerTexto("Nombre del servicio: ");
        Servicio servicio = new Servicio(nombre);
        if (servicioService.registrarServicio(servicio)) {
            System.out.println("Servicio registrado con éxito.");
        } else {
            System.out.println("El servicio ya existe.");
        }
    }

    private void crearReserva() {
        System.out.println("--- CREAR RESERVA ---");
        String idCliente = leerTexto("ID del Cliente: ");
        Optional<Cliente> clienteOpt = clienteService.buscarPorId(idCliente);
        if (clienteOpt.isEmpty()) {
            System.out.println("Cliente no encontrado. Debe registrarlo primero.");
            return;
        }
        String nombreServicio = leerTexto("Nombre del Servicio: ");
        Servicio servicio = new Servicio(nombreServicio);
        boolean servicioExiste = servicioService.listarCatalogo().stream()
                .anyMatch(s -> s.nombreTipo().equals(servicio.nombreTipo()));
        if (!servicioExiste) {
            System.out.println("El servicio no está en el catálogo. Regístrelo primero.");
            return;
        }
        String idReserva = leerTexto("Código único de la reserva: ");
        LocalDateTime fecha = leerFecha("Fecha y hora (yyyy-MM-dd HH:mm): ");
        NivelPrioridad prioridad = leerPrioridad();
        Reserva reserva = new Reserva(idReserva, fecha, servicio, clienteOpt.get(), prioridad);
        if (reservaService.crearReserva(reserva)) {
            System.out.println("Reserva creada exitosamente.");
        } else {
            System.out.println("Error: Ya existe una reserva con ese código.");
        }
    }

    private void buscarReserva() {
        String codigo = leerTexto("Ingrese el código de la reserva a buscar: ");
        Optional<Reserva> reserva = reservaService.buscarPorCodigo(codigo);
        if (reserva.isPresent()) {
            System.out.println("Reserva encontrada: " + reserva.get());
        } else {
            System.out.println("No se encontró ninguna reserva con el código: " + codigo);
        }
    }

    private void modificarReserva() {
        System.out.println("--- MODIFICAR RESERVA ---");
        String codigo = leerTexto("Ingrese el código de la reserva a modificar: ");
        Optional<Reserva> reservaActual = reservaService.buscarPorCodigo(codigo);
        if (reservaActual.isEmpty()) {
            System.out.println("No se encontró ninguna reserva con ese código.");
            return;
        }
        System.out.println("Reserva actual: " + reservaActual.get());
        LocalDateTime nuevaFecha = leerFecha("Nueva fecha y hora (yyyy-MM-dd HH:mm): ");
        NivelPrioridad nuevaPrioridad = leerPrioridad();
        if (reservaService.modificarReserva(codigo, nuevaFecha, nuevaPrioridad)) {
            System.out.println("Reserva modificada exitosamente.");
        } else {
            System.out.println("Error al modificar la reserva.");
        }
    }

    private void cancelarReserva() {
        System.out.println("--- CANCELAR RESERVA ---");
        String codigo = leerTexto("Ingrese el código de la reserva a cancelar: ");
        if (reservaService.cancelarReserva(codigo)) {
            System.out.println("Reserva cancelada exitosamente.");
        } else {
            System.out.println("No se encontró la reserva o no se pudo cancelar.");
        }
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }

    private LocalDateTime leerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine();
            try {
                return LocalDateTime.parse(input, Reserva.FORMATO_FECHA);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Use el formato yyyy-MM-dd HH:mm.");
            }
        }
    }

    private NivelPrioridad leerPrioridad() {
        while (true) {
            System.out.println("Seleccione prioridad: 1. VIP_ESPECIAL, 2. URGENTE, 3. NORMAL");
            int op = leerEntero("Opción: ");
            switch (op) {
                case 1: return NivelPrioridad.VIP_ESPECIAL;
                case 2: return NivelPrioridad.URGENTE;
                case 3: return NivelPrioridad.NORMAL;
                default: System.out.println("Opción no válida.");
            }
        }
    }
}
