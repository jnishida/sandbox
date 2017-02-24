package model;

import java.util.List;

public class Model1 {
	private String code;
	private String name;
	private Model2 model2;
	private List<Model2> model2List;

	public Model1() {
	}

	public Model1(String code, String name, Model2 model2, List<Model2> model2List) {
		this.code = code;
		this.name = name;
		this.model2 = model2;
		this.model2List = model2List;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Model2 getModel2() {
		return model2;
	}

	public void setModel2(Model2 model2) {
		this.model2 = model2;
	}

	public List<Model2> getModel2List() {
		return model2List;
	}

	public void setModel2List(List<Model2> model2List) {
		this.model2List = model2List;
	}

	@Override
	public String toString() {
		return String.format("Model1 [code=%s, model2List=%s, name=%s, toString()=%s]", code, model2List, name, super
			.toString());
	}
}
