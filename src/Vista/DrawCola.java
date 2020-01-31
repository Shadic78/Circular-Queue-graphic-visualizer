package Vista;

public class DrawCola {
    private DrawAnillo anillo;
    private DrawIndices indices;
    private DrawValores valores;
    private DrawFlechas flechas;
    private DrawSimbologia simbologia;
    
    public void draw() {            
        anillo.draw();
        indices.draw();
        valores.draw();
        flechas.draw();
        simbologia.draw();
    } 

    public DrawAnillo getAnillo() {
        return anillo;
    }

    public void setAnillo(DrawAnillo anillo) {
        this.anillo = anillo;
    }

    public DrawIndices getIndices() {
        return indices;
    }

    public void setIndices(DrawIndices indices) {
        this.indices = indices;
    }

    public DrawValores getValores() {
        return valores;
    }

    public void setValores(DrawValores valores) {
        this.valores = valores;
    }

    public DrawFlechas getFlechas() {
        return flechas;
    }

    public void setFlechas(DrawFlechas flechas) {
        this.flechas = flechas;
    }

    public DrawSimbologia getSimbologia() {
        return simbologia;
    }

    public void setSimbologia(DrawSimbologia simbologia) {
        this.simbologia = simbologia;
    }
    
}
