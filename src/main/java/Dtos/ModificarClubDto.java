package Dtos;

public class ModificarClubDto {
	private long idClub;
	private String nombreClub;
	private String sedeClub;
	//Getters & Setters 
	public long getIdClub() {
		return idClub;
	}
	public void setIdClub(long idClub) {
		this.idClub = idClub;
	}
	public String getNombreClub() {
		return nombreClub;
	}
	public void setNombreClub(String nombreClub) {
		this.nombreClub = nombreClub;
	}
	public String getSedeClub() {
		return sedeClub;
	}
	public void setSedeClub(String sedeClub) {
		this.sedeClub = sedeClub;
	}
	
}
