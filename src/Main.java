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
        setId();
        setVotanteId();
        setCandidatoId();
        setTimeStamps();
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
            String hora = java.time.LocalTime.now().toString();
            Voto voto = new Voto(idCounter++, votante.getId(), candidatoID, hora);


            for (int i = 0; i < listaCandidatos.size(); i++) {
                if (listaCandidatos.get(i).getId() == candidatoID) {
                    if (reportarVoto(listaCandidatos.get(i),voto.getId())) {


                    }
                    historialVoto.push(voto);
                    listaCandidatos.get(i).agregarVoto(voto);
                }
            }
            votante.marcarComoVotado();
        }
    }

    public void reportarVoto(Candidato candidato, int idVoto) {
                Queue <Voto> votosauxiliares = new LinkedList<>();
        for (int i = 0; i < candidato.getVotosRecibidos().size(); i++) {
            votosauxiliares=candidato.getVotosRecibidos();




        }

    }
        return boolean confirmado = true;
}


public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
    }
}