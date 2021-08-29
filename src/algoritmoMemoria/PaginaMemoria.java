package algoritmoMemoria;

import java.util.ArrayList;

public class PaginaMemoria {

	int id;
	int ref;
	int mod;
	
	public int idMaior(ArrayList<PaginaMemoria> lista) {//verifica um id que seja maior dos que ja tem na lista
		int idMaior = 0;
		for (PaginaMemoria pag : lista) {
			if (pag.id > idMaior) {
				idMaior = pag.id;
			}
		}
		return idMaior;
	}

	public PaginaMemoria(int id, int ref, int mod) {
		super();
		this.id = id;
		this.ref = ref;
		this.mod = mod;
	}
	
	public PaginaMemoria() {
	}
	
	@Override
	public String toString() {
		return "  Id = "+ id + " -------> "+ ref+ "    ---------------> "+ mod;
	}
	
	
	public int hastCode() {
		final int prime = 31;
		int res = 1;
		res = prime * res + id;
		res = prime * res + mod;
		res = prime * res + ref;
		return res;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		PaginaMemoria other = (PaginaMemoria) obj;
		if(id != other.id)
			return false;
		if(mod != other.mod)
			return false;
		if(ref != other.ref)
			return false;
		return true;
	}
	
	
	
}
