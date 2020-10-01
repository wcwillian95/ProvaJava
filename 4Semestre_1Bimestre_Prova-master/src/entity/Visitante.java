package entity;

import java.sql.Date;

public class Visitante {

	private int id;
	private String Nome;
	private String RG;
	private String CPF;
	private String Telefone;
	private String Email;
	private Date DataVisita;
	
	public Visitante(int id, String nome, String RG, String CPF, String Telefone,
			String Email, Date DataVisita) {
		super();
		this.id = id;
		this.Nome = nome;
		this.RG = RG;
		this.CPF = CPF;
		this.Telefone = Telefone;
		this.Email = Email;
		this.DataVisita = DataVisita;
	}
	
	public Visitante(String nome, String RG, String CPF, String Telefone,
			String Email, Date DataVisita) {
		super();
		this.Nome = nome;
		this.RG = RG;
		this.CPF = CPF;
		this.Telefone = Telefone;
		this.Email = Email;
		this.DataVisita = DataVisita;
	}

	public Visitante() {
		super();
	}
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getDataVisita() {
		return DataVisita;
	}
	public void setDataVisita(Date dataVisita) {
		DataVisita = dataVisita;
	}
	
	@Override
	public String toString() {
		return "id:" + id + ", Nome:" + Nome + ", RG:" + RG + ", CPF:" + CPF + ", Telefone:" + Telefone
				+ ", Email:" + Email + ", DataVisita:" + DataVisita ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
		result = prime * result + ((DataVisita == null) ? 0 : DataVisita.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((RG == null) ? 0 : RG.hashCode());
		result = prime * result + ((Telefone == null) ? 0 : Telefone.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visitante other = (Visitante) obj;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		if (DataVisita == null) {
			if (other.DataVisita != null)
				return false;
		} else if (!DataVisita.equals(other.DataVisita))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (RG == null) {
			if (other.RG != null)
				return false;
		} else if (!RG.equals(other.RG))
			return false;
		if (Telefone == null) {
			if (other.Telefone != null)
				return false;
		} else if (!Telefone.equals(other.Telefone))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	
	
}
