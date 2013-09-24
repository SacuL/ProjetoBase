package sonda.models;

import java.io.Serializable;

import org.primefaces.event.map.OverlaySelectEvent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@ViewScoped
public class MapBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private MapModel mapModel;
	private Marker marker;

	public MapBean() {
		mapModel = new DefaultMapModel();

		LatLng coord1 = new LatLng(-21.770938, -43.376047);
		LatLng coord2 = new LatLng(-21.773210, -43.369352);
		LatLng coord3 = new LatLng(-21.776000, -43.380000);

		mapModel.addOverlay(new Marker(coord1, "Exemplo 1", "Coleta de dados 1"));
		mapModel.addOverlay(new Marker(coord2, "Exemplo 2", "Coleta de dados 2"));
		mapModel.addOverlay(new Marker(coord3, "Exemplo 3", "Coleta de dados 3"));

	}

	public void onMarkerSelect(OverlaySelectEvent event) {
		this.marker = (Marker) event.getOverlay();
	}

	public MapModel getMapModel() {
		return this.mapModel;
	}

	public Marker getMarker() {
		return this.marker;
	}

}