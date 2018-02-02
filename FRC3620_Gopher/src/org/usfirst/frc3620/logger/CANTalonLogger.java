package org.usfirst.frc3620.logger;

import org.usfirst.frc3620.logger.FastDataLoggerCollections;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class CANTalonLogger {
	public static void startCANTalonPositionLogger(String name, final WPI_TalonSRX talon) {
		IFastDataLogger iFastDataLogger;
		iFastDataLogger = new FastDataLoggerCollections();
		iFastDataLogger.setInterval(0.001);
		iFastDataLogger.setMaxLength(2.000);
		iFastDataLogger.setFilename(name);

		/*iFastDataLogger.addMetadata("P", talon.getP());
		iFastDataLogger.addMetadata("I", talon.getI());
		iFastDataLogger.addMetadata("D", talon.getD());
		iFastDataLogger.addMetadata("F", talon.getF());*/

		iFastDataLogger.addDataProvider("error", () -> talon.getLastError());
		iFastDataLogger.addDataProvider("outputCurrent", () -> talon.getOutputCurrent());
		iFastDataLogger.addDataProvider("outputVoltage", () -> talon.getMotorOutputVoltage());

		iFastDataLogger.start();
	}
}
