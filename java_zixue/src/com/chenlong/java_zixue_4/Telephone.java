package com.chenlong.java_zixue_4;

abstract class Telephone { // 声明为抽象类
	String phoneNumber;
	final int LOCAL_CALL = 1;
	final int DISTANCE_CALL = 3;
	final int INTERNATIONAL_CALL = 9;
	double balance;

	abstract boolean chargeStyle(int callMode);

	double getBalance() {
		return balance;
	}
}

// 声明移动电话MobilePhone类
class MobilePhone extends Telephone { // 移动网络
	String networkType;

	String getType() {
		return networkType;
	}

	boolean chargeStyle(int callMode) {
		if (balance > 0.4) {
			balance -= 0.4;
			return true;
		} else
			return false;
	}
}

// FixPhone类没有实现Telephone类的chargeStyle（int）方法；必须声明为抽象类，
abstract class FixPhone extends Telephone {
	double monthFee;
}

// 定义普通电话类OrdinaryPhone类
class OrdinaryPhone extends FixPhone {
	// 是否长途电话
	boolean longdistanceService;
	// 是否国际长途
	boolean internationalService;
	double balance;

	boolean chargeStyle(int callMode) {
		if (callMode == DISTANCE_CALL && !longdistanceService)
			return false;
		if (callMode == INTERNATIONAL_CALL && !internationalService)
			return false;
		if (balance > (0.4 * callMode)) {
			balance -= 0.4 * callMode;
			return true;
		} else
			return false;
	}
}