package support;

import java.util.Arrays;
import java.util.List;

import model.Model1;
import model.Model2;

import org.junit.Test;


public class AssertUtilTest {
	public void testCollection1() throws Exception {
		List<Model1> actual = null;
		List<Model1> expected = null;

		AssertUtil.assertCollection(actual, expected);
	}

	@Test(expected = AssertionError.class)
	public void testCollection2() throws Exception {
		List<Model1> actual = null;
		List<Model1> expected = list();
		;

		AssertUtil.assertCollection(actual, expected);
	}

	@Test(expected = AssertionError.class)
	public void testCollection3() throws Exception {
		List<Model1> actual = list();
		List<Model1> expected = null;

		AssertUtil.assertCollection(actual, expected);
	}

	@Test
	public void testCollection4() throws Exception {
		List<Model1> actual = list();
		List<Model1> expected = list();

		AssertUtil.assertCollection(actual, expected);
	}

	@Test(expected = AssertionError.class)
	public void testCollection5() throws Exception {
		List<Model1> actual = list();
		List<Model1> expected = list();
		expected.get(0).getModel2List().get(0).setField3("diff");

		AssertUtil.assertCollection(actual, expected);
	}

	@Test
	public void testCollection6() throws Exception {
		List<Model1> actual = list();
		List<Model1> expected = list();
		expected.get(0).getModel2List().get(0).setField3("diff");

		AssertUtil.assertCollection(actual, expected, "field3");
	}

	@Test
	public void testElement1() throws Exception {
		Model1 actual = null;
		Model1 expected = null;

		AssertUtil.assertElement(actual, expected);
	}

	@Test(expected = AssertionError.class)
	public void testElement2() throws Exception {
		Model1 actual = null;
		Model1 expected = model1();

		AssertUtil.assertElement(actual, expected);
	}

	@Test(expected = AssertionError.class)
	public void testElement3() throws Exception {
		Model1 actual = model1();
		Model1 expected = null;

		AssertUtil.assertElement(actual, expected);
	}

	@Test
	public void testElement4() throws Exception {
		Model1 actual = model1();
		Model1 expected = model1();

		AssertUtil.assertElement(actual, expected);
	}

	@Test(expected = AssertionError.class)
	public void testElement5() throws Exception {
		Model1 actual = model1();
		Model1 expected = model1();
		expected.getModel2List().get(0).setField3("diff");

		AssertUtil.assertElement(actual, expected);
	}

	@Test
	public void testElement6() throws Exception {
		Model1 actual = model1();
		Model1 expected = model1();
		expected.getModel2List().get(0).setField3("diff");

		AssertUtil.assertElement(actual, expected, "field3"); 
	}

	private List<Model1> list() {
		return Arrays.asList(model1());
	}

	private Model1 model1() {
		return new Model1("1111", "あああ", model2(), Arrays.asList(model2()));
		}

	private Model2 model2() {
		return new Model2("field1", "field2", "field3");
	}
}
