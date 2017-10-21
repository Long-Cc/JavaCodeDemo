package com.chenlong.java_zixue_4;

abstract class Telephone { // ����Ϊ������
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

// �����ƶ��绰MobilePhone��
class MobilePhone extends Telephone { // �ƶ�����
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

// FixPhone��û��ʵ��Telephone���chargeStyle��int����������������Ϊ�����࣬
abstract class FixPhone extends Telephone {
	double monthFee;
}

// ������ͨ�绰��OrdinaryPhone��
class OrdinaryPhone extends FixPhone {
	// �Ƿ�;�绰
	boolean longdistanceService;
	// �Ƿ���ʳ�;
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