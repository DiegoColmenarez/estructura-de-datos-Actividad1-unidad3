package org.com.ui;

import org.com.service.*;
import org.com.model.*;
import java.time.LocalDateTime;

public class Main {
    private static void cargarDatosIniciales(ClienteService cs, ServicioService ss, ReservaService rs) {
        Cliente c1 = new Cliente("CC1045", "Andrés Mendoza", "andres.mendoza@mail.com");
        Cliente c2 = new Cliente("PA9876", "Sarah O'Connor", "sarah.tourist@mail.com");
        Cliente c3 = new Cliente("CE5678", "Carlos Vives", "carlos.v@mail.com");
        Cliente c4 = new Cliente("CC3321", "Valeria Restrepo", "vale.restrepo@mail.com");
        Cliente c5 = new Cliente("CC9988", "Luis Fernando Diaz", "luis.diaz@mail.com");

        cs.registrarCliente(c1);
        cs.registrarCliente(c2);
        cs.registrarCliente(c3);
        cs.registrarCliente(c4);
        cs.registrarCliente(c5);

        Servicio s1 = new Servicio("Tour Islas del Rosario");
        Servicio s2 = new Servicio("Cena Romántica Ciudad Amurallada");
        Servicio s3 = new Servicio("Buceo en Barú");
        Servicio s4 = new Servicio("Paseo en Chiva Rumbera");
        Servicio s5 = new Servicio("Spa y Masaje Getsemaní");

        ss.registrarServicio(s1);
        ss.registrarServicio(s2);
        ss.registrarServicio(s3);
        ss.registrarServicio(s4);
        ss.registrarServicio(s5);

        rs.crearReserva(new Reserva("RES-001",
                LocalDateTime.of(2026, 10, 22, 8, 30), s1, c1, NivelPrioridad.NORMAL));
        rs.crearReserva(new Reserva("RES-002",
                LocalDateTime.of(2026, 10, 22, 20, 0), s2, c2, NivelPrioridad.VIP_ESPECIAL));

        rs.crearReserva(new Reserva("RES-003",
                LocalDateTime.of(2026, 10, 23, 9, 0), s3, c5, NivelPrioridad.URGENTE));

        rs.crearReserva(new Reserva("RES-004",
                LocalDateTime.of(2026, 10, 23, 21, 0), s4, c4, NivelPrioridad.NORMAL));

        rs.crearReserva(new Reserva("RES-005",
                LocalDateTime.of(2026, 10, 24, 10, 0), s5, c3, NivelPrioridad.VIP_ESPECIAL));

        rs.crearReserva(new Reserva("RES-006",
                LocalDateTime.of(2026, 10, 24, 8, 30), s1, c2, NivelPrioridad.NORMAL));

        rs.crearReserva(new Reserva("RES-007",
                LocalDateTime.of(2026, 10, 25, 19, 30), s2, c1, NivelPrioridad.NORMAL));

        rs.crearReserva(new Reserva("RES-008",
                LocalDateTime.of(2026, 10, 25, 7, 0), s3, c3, NivelPrioridad.VIP_ESPECIAL));

        rs.crearReserva(new Reserva("RES-009",
                LocalDateTime.of(2026, 10, 26, 20, 30), s4, c5, NivelPrioridad.URGENTE));

        rs.crearReserva(new Reserva("RES-010",
                LocalDateTime.of(2026, 10, 26, 11, 0), s5, c4, NivelPrioridad.NORMAL));

        rs.crearReserva(new Reserva("RES-011",
                LocalDateTime.of(2026, 10, 27, 8, 30), s1, c5, NivelPrioridad.NORMAL));

        rs.crearReserva(new Reserva("RES-012",
                LocalDateTime.of(2026, 10, 28, 20, 0), s2, c4, NivelPrioridad.URGENTE));

        rs.crearReserva(new Reserva("RES-013",
                LocalDateTime.of(2026, 10, 29, 9, 30), s3, c1, NivelPrioridad.NORMAL));

        rs.crearReserva(new Reserva("RES-014",
                LocalDateTime.of(2026, 10, 30, 21, 0), s4, c2, NivelPrioridad.VIP_ESPECIAL));

        rs.crearReserva(new Reserva("RES-015",
                LocalDateTime.of(2026, 10, 31, 16, 0), s5, c3, NivelPrioridad.NORMAL));
    }
}
