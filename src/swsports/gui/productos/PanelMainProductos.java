package swsports.gui.productos;

import java.awt.Color;
import java.util.LinkedHashMap;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import swsports.gui.AbstractPanelMain;
import swsports.modelo.TransferProducto;
import swsports.modelo.Producto;
import swsports.productos.ControladorProductos;

public class PanelMainProductos extends AbstractPanelMain<Producto> {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.add(new PanelMainProductos(new ControladorProductos()));
		frame.pack();
		frame.setVisible(true);
	}

	private JTextField idTextField;
	private JTextField nombreTextField;
	private JTextField descTextField;
	private JTextField stockTextField;
	private JTextField precioTextField;
	private ControladorProductos controlador;

	private class BuscarUsuarioWorker extends BuscarSwingWorker {

		@Override
		protected Void doInBackground() throws Exception {
			setSearchButtonEnabled(false);

			String id = idTextField.getText().equals("") ? null : idTextField.getText();
			String nombre = nombreTextField.getText().equals("") ? null : nombreTextField.getText();
			String desc =  descTextField.getText().equals("") ? null : descTextField.getText();
			Integer stock = stockTextField.getText().equals("") ? null : Integer.valueOf(stockTextField.getText());
			Double precio = precioTextField.getText().equals("") ? null : Double.valueOf(precioTextField.getText());

			TransferProducto tProd = new TransferProducto(id, nombre, desc, stock, precio);
			objetos = controlador.busquedaProducto(tProd);

			removeReportablePanels();
			for (Producto p : objetos) {
				publish(new ProductoDataPanel(p, tProd, controlador));
			}
						
			return null;
		}
	}
	
	public PanelMainProductos(ControladorProductos ctrl) {
		super("Productos");
		controlador = ctrl;
	}

	@Override
	protected LinkedHashMap<String, JComponent> getComponentesBusqueda() {
		LinkedHashMap<String, JComponent> map = new LinkedHashMap<>();

		idTextField = createTextField();
		map.put("ID", idTextField);
		nombreTextField = createTextField();
		map.put("Nombre", nombreTextField);
		descTextField = createTextField();
		map.put("Descripcion", descTextField);
		stockTextField = createTextField();
		map.put("Stock", stockTextField);
		precioTextField = createTextField();
		map.put("Precio", precioTextField);

		JPanel lateralAdminPanel = new JPanel();
		lateralAdminPanel.setBackground(Color.ORANGE);
		lateralAdminPanel.setLayout(new BoxLayout(lateralAdminPanel, BoxLayout.Y_AXIS));
		
		return map;
	}

	@Override
	protected AbstractPanelMain<Producto>.BuscarSwingWorker getNewSwingWorker() {
		return new BuscarUsuarioWorker();
	}

}