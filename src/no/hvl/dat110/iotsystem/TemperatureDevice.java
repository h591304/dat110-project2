package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start

		// create a client object and use it to

		Client user = new Client("sensor", Common.BROKERHOST, Common.BROKERPORT);
		
		// - connect to the broker - user "sensor" as the user name
		// - publish the temperature(s)
		// - disconnect from the broker
		
		user.connect();
		
		for(int i=0; i < COUNT; i++) {
			String tempStr = String.valueOf(sn.read());
			user.publish(Common.TEMPTOPIC, tempStr);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		user.disconnect();

		// TODO - end

		System.out.println("Temperature device stopping ... ");
	}
}
