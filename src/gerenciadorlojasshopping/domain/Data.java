package gerenciadorlojasshopping.domain;

public class Data {
    private int dia, mes, ano;

    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        if (dia == 31 && mes == 2 || dia == 31 && mes == 4 || dia == 31 && mes == 6 ||
                dia == 31 && mes == 9 || dia == 31 && mes == 11) {
            System.out.println("Erro: o mês preenchido não pode ter 31 dias.");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
        if (dia == 29 && mes == 2 && verificaAnoBissexto() == false){
            System.out.println("Erro: não é possível haver 29/02, pois o ano não é bissexto");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
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
