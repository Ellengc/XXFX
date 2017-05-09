package Action;

import com.opensymphony.xwork2.ActionContext;

import Entity.Guitar;
import Entity.Inventory;
import net.sf.json.JSONObject;

public class GuitarAction extends BaseAction<Guitar> {
	public String serialNumber;
	public String price;
	public String model;
	private String builder, type, backWood, topWood;

	public void setModel(String model) {
		this.model = model;
	}

	public String getBuilder() {
		return builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBackWood() {
		return backWood;
	}

	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}

	public String getTopWood() {
		return topWood;
	}

	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}

	public String add() {
		  Guitar guitar = new Guitar(1,100.00,"1��","aģ��","a����","ǰ��1","����1");
		  Guitar guitar2 = new Guitar(2,100.00,"2��","2ģ��","2����","ǰ��2","����2");
		  Guitar guitar3 = new Guitar(3,100.00,"1��","3ģ��","3����","ǰ��1","����1");
		guitarService.addGuitar(guitar);
		guitarService.addGuitar(guitar2);
		guitarService.addGuitar(guitar3);
		ActionContext.getContext().getSession().put("result", "������");	
		return SUCCESS;
		
	}

	public String search() {
		lists = guitarService.queryallGuitar();
		System.out.println(lists.size());
		Inventory inventory = new Inventory();
		inventory.setGuitars(lists);
		Guitar guitar = new Guitar();
		guitar.setBackWood(backWood);
		guitar.setTopWood(topWood);
		guitar.setBuilder(builder);
		guitar.setModel(model);
		guitar.setType(type);
		lists = inventory.search(guitar);
		System.out.println(lists.size());
		ActionContext.getContext().getSession().put("list", lists);	
		return SUCCESS;

	}
}
