package org.com.ui;

import org.com.model.Cliente;
import org.com.model.Servicio;
import org.com.service.ClienteService;
import org.com.service.ReservaService;
import org.com.service.ServicioService;

import java.time.LocalDateTime;
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
}
