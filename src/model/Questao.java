package model;

public class Questao {

	private String pergunta, op1, op2, op3, opCorreta;

	public Questao(String pergunta, String op1, String op2, String op3, String opCorreta) {
		this.pergunta = pergunta;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.opCorreta = opCorreta;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getOp1() {
		return op1;
	}

	public void setOp1(String op1) {
		this.op1 = op1;
	}

	public String getOp2() {
		return op2;
	}

	public void setOp2(String op2) {
		this.op2 = op2;
	}

	public String getOp3() {
		return op3;
	}

	public void setOp3(String op3) {
		this.op3 = op3;
	}

	public String getOpCorreta() {
		return opCorreta;
	}

	@Override
	public String toString() {
		return "Questao [pergunta=" + pergunta + ", op1=" + op1 + ", op2=" + op2 + ", op3=" + op3 + ", opCorreta="
				+ opCorreta + "]";
	}

	public void setOpCorreta(String opCorreta) {
		this.opCorreta = opCorreta;
	}
	
}
