package Banco;

public abstract class Conta implements IConta {
	
	private static int AGENCIA_PADRAO = 1;
	private int SEQUENCIAL = 1;
	
		
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

	
	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.saldo = 0;
		this.cliente = cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}



	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


    public void sacar(double valor) {
		saldo =- valor;
		
	}
	
    public void depositar(double valor) {
		saldo =+ valor;
		
	}
    
   
    public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
    protected void imprimirInformacoesComuns() {
    	System.out.println(String.format("Titulae: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
    
}
