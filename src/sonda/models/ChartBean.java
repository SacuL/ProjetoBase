package sonda.models;

import java.io.Serializable;
import java.util.List;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ChartBean implements Serializable {

	/**
	 * Auto Generated Default serial version
	 */
	private static final long serialVersionUID = 1L;

	private CartesianChartModel categoryModel;

	private CartesianChartModel linearModel;

	public ChartBean() {
		createCategoryModel();
		createLinearModel();
	}

	public CartesianChartModel getCategoryModel() {
		return categoryModel;
	}

	public CartesianChartModel getLinearModel() {
		return linearModel;
	}

	private void createCategoryModel() {
		categoryModel = new CartesianChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Boys");

		boys.set("2004", 120);
		boys.set("2005", 100);
		boys.set("2006", 44);
		boys.set("2007", 150);
		boys.set("2008", 25);

		ChartSeries girls = new ChartSeries();
		girls.setLabel("Girls");

		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 110);
		girls.set("2007", 135);
		girls.set("2008", 120);

		categoryModel.addSeries(boys);
		categoryModel.addSeries(girls);

	}

	private void createLinearModel() {

		linearModel = new CartesianChartModel();

		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Sensor 1");

		LeituraDados leitura = new LeituraDados();
		List<Integer> dados = leitura.getDados(21);

		int contador = 1;
		for (int dado : dados) {
			series1.set(contador, dado);
			contador++;
		}

		LineChartSeries series2 = new LineChartSeries();
		series2.setLabel("Sensor 2");
		series2.setMarkerStyle("diamond");

		LeituraDados leitura2 = new LeituraDados();
		List<Integer> dados2 = leitura2.getDados(19);

		contador = 1;
		for (int dado : dados2) {
			series2.set(contador, dado);
			contador++;
		}

		linearModel.addSeries(series1);
		linearModel.addSeries(series2);

	}
}