package com.chenlong.java_zixue_13;

public class EcmDef {
	public static void main(String[] args) {
		try {
			int i = Integer.parseInt(args[0]);
			int j = Integer.parseInt(args[1]);
			EcmDef ecm1=new EcmDef();
			ecm1.ecm(i, j);
		} catch (NumberFormatException e) {
			System.out.println("������������Ͳ�һ��");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ȱ�������в���");
		}catch(ArithmeticException e){
			System.out.println("��ĸΪ��");
		}catch(EcDef e){
			System.out.println(e.getMessage());
		}
	}

	public  void ecm(int i, int j) throws EcDef {
		if(i<0||j<0){
			throw new EcDef("������������и���");
		}
		System.out.println(i/j);
	}

	class EcDef extends Exception {
		static final long serialVersionUID = -3387516994229948L;

		public EcDef() {
		        super();
		    }

		public EcDef(String message) {
		        super(message);
		    }
	}
}