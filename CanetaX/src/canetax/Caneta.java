
package canetax;

public class Caneta {
    
    //atributos (características e estados)
    public String modelo;
    public String cor;
    public Double ponta;
    public int carga;
    public boolean tampada;
    
    //métodos(comportamentos codificados)
    public String escrever() {
        return "Escrevendo...";
    }

    public String rabiscar() {
        return "Rabiscando...";
    }

    public String pintar() {
        return "Pintando...";
    }

    public String tampar() {
        if (!tampada) {
            tampada = true;
            return "A caneta foi TAMPADA com sucesso!";
        } else {
            return "A caneta já está tampada!";
        }
    }

    public String destampar() {
        if (tampada) {
            tampada = false;
            return "A caneta foi DESTAMPADA com sucesso!";
        } else {
            return "A caneta já está destampada!";
        }
    }

    @Override
    public String toString() {
        return "Caneta{" + "modelo=" + modelo + ", cor=" + cor + ", ponta=" + ponta + ", carga=" + carga + ", tampada=" + tampada + '}';
    }
    
    
    
}
