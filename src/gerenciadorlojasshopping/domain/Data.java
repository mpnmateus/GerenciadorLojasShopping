package gerenciadorlojasshopping.domain;

public class Data {
    private int dia, mes, ano;

    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        if (dia == 29 && mes == 2 && verificaAnoBissexto() == false){
            System.out.println("Erro: não é possível haver 29/02, pois o ano não pe bissexto");
        }
    }
    @Override
    public String toString(){
        return "Data: "+this.dia+"/"+this.mes+"/"+this.ano;
    }

    public boolean verificaAnoBissexto(){
        return (ano % 4 == 0 && ano % 100 !=0) || (ano % 400 == 0);
    }

    public int getDia() { return dia; }
    public void setDia(int dia) { this.dia = dia; }
    public int getMes() { return mes; }
    public void setMes(int mes) { this.mes = mes; }
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
}
