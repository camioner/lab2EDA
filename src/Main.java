//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Voto {
    private int id = 0;
    private int votanteId = 0;
    private int candidatoId = 0;
    private String timeStamps = "";

    public Voto(int id, int votanteId, int candidatoId, String timeStamps) {
        this.id = id;
        this.votanteId = votanteId;
        this.candidatoId = candidatoId;
        this.timeStamps = timeStamps;
    }

    public void setId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el id del votante: ");
        this.id = sc.nextInt();
    }

    public void setVotanteId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el id del votante: ");
        this.votanteId = sc.nextInt();
    }

    public void setCandidatoId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el id del candidato: ");
        this.candidatoId = sc.nextInt();
    }

    public void setTimeStamps() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el la hora del voto: ");
        this.timeStamps = sc.nextLine();
    }

    public int getId() {
        return id;
    }

    public int getVotanteId() {
        return votanteId;
    }

    public int getCandidatoId() {
        return candidatoId;
    }

    public String getTimeStamps() {
        return timeStamps;
    }

}

class Candidato {
    private int id;
    private String nombre;
    private String partido;
    private Queue<Voto> votosRecibidos;

    public Candidato(int id, String nombre, String partido) {
        this.id = id;
        this.nombre = nombre;
        this.partido = partido;
        this.votosRecibidos = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPartido() {
        return partido;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public void agregarVoto(Voto v) {
        votosRecibidos.add(v);
    }

    public Queue<Voto> getVotosRecibidos() {
        return votosRecibidos;
    }

}

class Votante {
    private int id = 0;
    private String nombre = "";
    private boolean yaVoto = false;

    public Votante() {
        setId();
        setNombre();
        setYaVoto();

    }

    public void setId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el id del votante: ");
        this.id = sc.nextInt();
    }

    public void setNombre() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el nombre: ");
        this.nombre = sc.nextLine();
    }

    public void setYaVoto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite si ya voto: ");
        this.yaVoto = sc.nextBoolean();
    }

    public int getId() {
        return id;
    }

    public boolean getYaVoto() {
        return yaVoto;
    }

    public void marcarComoVotado() {
        this.yaVoto = true;
    }

}

class UrnaElectoral {
    private LinkedList<Candidato> listaCandidatos = new LinkedList<>();
    private Stack<Voto> historialVoto = new Stack<>();
    private Queue<Voto> votosReportados = new LinkedList<>();
    private int idCounter = 0;

    public boolean verificarVotante(Votante votante) {
        return votante.getYaVoto();
    }

    public void registrarVoto(Votante votante, int candidatoID) {

        if (!verificarVotante(votante)) {
            System.out.println("El votante ya ha votado");
            return;
        }
        Candidato candidato = getcandidato(candidatoID);
        if (candidato == null) {
            System.out.println("no se enccuenta el candidato");
        }

        String hora = java.time.LocalTime.now().toString();
        Voto voto = new Voto(idCounter++, votante.getId(), candidatoID, hora);

        historialVoto.push(voto);
        candidato.agregarVoto(voto);
        votante.marcarComoVotado();


    }

    public void reportarVoto(Candidato candidato, int idVoto) {
        Queue<Voto> votosauxiliares = new LinkedList<>();
        boolean yes = false;

        for (int i = 0; i < candidato.getVotosRecibidos().size(); i++) {
            Voto v = candidato.getVotosRecibidos().poll();
            if (v.getId() == idVoto) {
                votosReportados.add(v);
                yes = true;
                System.out.println("Voto con ID " + idVoto + " reportado correctamente.");
            } else {
                votosauxiliares.add(v);
            }
        }

        candidato.getVotosRecibidos().addAll(votosauxiliares);
        if (!yes) {
            System.out.println(" No se encontró un voto con ID " + idVoto + ".");
        }
    }

    public void obtenerResultados() {
        System.out.println("=== Resultados de la elección ===");

        if (listaCandidatos.isEmpty()) {
            System.out.println("No hay candidatos registrados.");
            return;
        }

        for (Candidato c : listaCandidatos) {
            String nombre = c.getNombre();
            String partido = c.getPartido();
            int cantidadVotos = c.getVotosRecibidos().size();

            System.out.println(nombre + " (" + partido + "): " + cantidadVotos + " votos");
        }
    }

    public void setListaCandidatos(Candidato c){
        listaCandidatos.add(c);
    }

    public Candidato getcandidato(int idcandidato) {
        for (Candidato c : listaCandidatos) {
            if (c.getId()==idcandidato) {
                return c;
            }
        }
        return null;
    }

}





public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome! , estas son las votaciones");
        while (true) {
            System.out.printf("escoja una opcion para continuar");
            System.out.printf("1. votar" +
                    "2.agregar candidato a la urna" + " "
            );
            Scanner sc = new Scanner(System.in);

        }







    }
}