package TrickeyProblem;

import java.util.Arrays;

public class CalcAngleBwHrandMin {
	
	public static float angleMin(int min){
		while(min>60){
			min-=60;
		}
		float angle = 360*min/60;
		System.out.println(angle);
		return angle;
		
		// Clock min hand goes 6 degree for every 1 min. it means evey second ticks 6 degree in a second.
		// hr hand goes 0.5 degree in 1 min so 30 Degree in 60 min 
	}
	
	public static float angleHr(int hr){
		while(hr>12){
			hr-=12;
		}
		float angle = 360*hr/12;
		System.out.println(angle);
		return angle;
	}
	
	public static float angleAtTime(String time){
		String [] timesplit = time.split(":");
		int hr = Integer.parseInt(timesplit[0]);
		int min = Integer.parseInt(timesplit[1]);
		float minangle = angleMin(min);
		float hrangle = 360 * (hr%12)/12 +360 * (min/60)*(1/12);
		
		float computeangle = (hrangle - minangle) % 360;
		System.out.println("computeangle"+hrangle);
		return hrangle;
	}
	
	public static void main(String[] args) {
		// Find the angle b/w Min hand and 12
		int min = 1502;
		int hr = 3;
		angleMin(min);
		angleHr(hr);
		angleAtTime("3:5");
	}
}
