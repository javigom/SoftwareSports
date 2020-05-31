package swsports.proveedores;

import java.util.List;

import swsports.daoproveedores.FachadaDAOProveedores;
import swsports.daoproveedores.IFachadaDAOProveedores;
import swsports.modelo.TransferProveedor;
import swsports.modelo.Proveedor;

class SAProveedores implements ISAProveedores {

	private IFachadaDAOProveedores dao;

	SAProveedores(){
		dao = new FachadaDAOProveedores();
	}

	@Override
	public List<Proveedor> busquedaProveedores(TransferProveedor tProv){
		return dao.busquedaProveedores(tProv);
	}


	@Override
	public Proveedor consultaProveedor(String id){
		return id == null ? null : dao.consultaProveedor(id);
	}

	@Override
	public boolean quitarProveedor(Proveedor prov){
		return (dao.consultaProveedor(prov.getId()) != null) && dao.quitarProveedor(prov);
	}

	@Override
	public boolean recibirPedido(String tProv){
		return dao.recibirPedido(tProv);
	}

	@Override
	public boolean editarProveedor(TransferProveedor tProv){
		return tProv != null && dao.editarProveedor(tProv);
	}

	@Override
	public boolean cancelarPedido(String tProv){
		return dao.cancelarPedido(tProv);
	}

	@Override
	public boolean anyadirProveedor(Proveedor prov){
		return prov != null && (dao.consultaProveedor(prov.getId()) == null) && dao.anyadirProveedor(prov);
	}

	@Override
	public boolean pedidoProveedor(TransferProveedor prov){
		return dao.consultaProveedor(prov.getId()) != null && dao.pedidoProveedor(prov);
	}

}
