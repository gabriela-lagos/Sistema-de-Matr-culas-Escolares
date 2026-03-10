public class Matricula {

    private int id;
    private int alunoId;
    private String semestre;

    public Matricula() {}

    public Matricula(int alunoId, String semestre) {
        this.alunoId = alunoId;
        this.semestre = semestre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}