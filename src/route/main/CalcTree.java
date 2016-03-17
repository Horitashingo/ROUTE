package route.main;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JApplet;

import nez.ast.CommonTree;
import nez.peg.tpeg.type.LType.TupleType;
import route.main.Translator;


public class Function {
	Map<String, Object> funcrecord = new HashMap<String, Object>();
	Map<Integer, Boolean> intReturnList = new HashMap<Integer, Boolean>();
	Map<Boolean, Boolean> boolReturnList = new HashMap<Boolean, Boolean>();
	ArrayList<SimpleEntry<String,Object>> argumentList = new ArrayList<SimpleEntry<String,Object>>();
	
	public Function(ArrayList<SimpleEntry<String, Object>> arguments, Map<Integer, Boolean> returnList){
		this.argumentList = arguments;
		this.intReturnList = returnList;
	}
	
	public Function(ArrayList<SimpleEntry<String, Object>> arguments, Map<Boolean, Boolean> returnList) {
		this.argumentList = arguments;
		this.boolReturnList = returnList;
	}
}

public abstract class CalcTree {
	List<CalcTree> child;

	public CalcTree() {
		this.child = new ArrayList<>();
	}

	public abstract Object accept(CalcVisitor visitor);

}

abstract class BinaryExpr extends CalcTree {

	public BinaryExpr(CalcTree left, CalcTree right) {
		super();
		this.child.add(left);
		this.child.add(right);
	}
}

class Source extends CalcTree {
	
	public Source(CommonTree... node) {
		super();
		for (int i = 0; i < node.length; i++) {
			CommonTree cnode = node[i].get(i);
			this.child.add(Translator.translate(cnode));
		}
	}

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}
}

class Funcdecl extends CalcTree {
	public Funcdecl(CommonTree... node) {
		super();
		for (int i = 0; i < node.length; i++) {
			CommonTree cnode = node[i].get(i);
			this.child.add(Translator.translate(cnode));
		}
	}
	
	

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}
}

class Returnlist extends BinaryExpr {
	public Returnlist(CalcTree left, CalcTree right){
		super(left,right);
	}

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}
}

class Vardecl extends BinaryExpr {
	
	public Vardecl(CalcTree left, CalcTree right){
		super(left, right);
	}

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}
}

class Add extends BinaryExpr {

	public Add(CalcTree left, CalcTree right) {
		super(left, right);
	}

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}

}

class Mul extends BinaryExpr {

	public Mul(CalcTree left, CalcTree right) {
		super(left, right);
	}

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}

}

class Equals extends BinaryExpr {

	public Equals(CalcTree left, CalcTree right) {
		super(left, right);
	}

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}

}

class NotEquals extends BinaryExpr {

	public NotEquals(CalcTree left, CalcTree right) {
		super(left, right);
	}

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}

}

class GreaterThan extends BinaryExpr {

	public GreaterThan(CalcTree left, CalcTree right) {
		super(left, right);
	}

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}

}

class GreaterThanEquals extends BinaryExpr {

	public GreaterThanEquals(CalcTree left, CalcTree right) {
		super(left, right);
	}

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}

}

class LessThan extends BinaryExpr {

	public LessThan(CalcTree left, CalcTree right) {
		super(left, right);
	}

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}

}

class LessThanEquals extends BinaryExpr {

	public LessThanEquals(CalcTree left, CalcTree right) {
		super(left, right);
	}

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}

}

class And extends BinaryExpr {
	public And(CalcTree left, CalcTree right){
		super(left, right);
	}

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}
}

class Or extends BinaryExpr {
	public Or(CalcTree left, CalcTree right){
		super(left, right);
	}

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}
	
}

class Unop extends BinaryExpr {
	public Unop(CalcTree left, CalcTree right){
		super(left,right);
	}

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}
}

class Int extends CalcTree {
	int val;

	public Int(int val) {
		this.val = val;
	}

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}

}

class In extends CalcTree {
	public In(CalcTree target){
		this.child.add(target);
	}
	
	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}
	
}

class Out extends CalcTree{
	public Out(CalcTree target){
		this.child.add(target);
	}

	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}
	
}

class Name extends CalcTree{
	String str;
	public Name(String str) {
		this.str = str;
	}
	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}
	
}

class True extends CalcTree{
	Boolean bool;
	public True(Boolean bool){
		this.bool=bool;
	}
	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}
}

class False extends CalcTree{
	Boolean bool;
	public False(Boolean bool) {
		this.bool= bool;
	}
	@Override
	public Object accept(CalcVisitor visitor) {
		return visitor.visit(this);
	}
	
}