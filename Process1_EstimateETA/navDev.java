public class navDev {

    public static void main() {
        boolean tApiIsConn = false;
        boolean gpsIsConn = false;
        
        double currTDensity;
        gpsCoords currPos;
        double ETA;
        gpsCoords endPos = new gpsCoords();

        tApiIsConn = checkTrafficConnection();

        gpsIsConn = checkGPSConnection();

        //Loop to continuously get necessary info to allow for real-time ETA updates
        if (tApiIsConn && gpsIsConn) {

            while (tApiIsConn && gpsIsConn) { 
                currTDensity = requestTrafficDensity();
                currPos = requestPosition();

                ETA = calculateETA(currTDensity, currPos, endPos);

                System.out.println(ETA);
            }

        } else {

            System.out.println("ERROR: Unable to calculate ETA - Device(s) could not be initialised");

        }

    }

    public static boolean checkTrafficConnection() {
        boolean tApiStatus = false;

        tApiStatus = trafficAPI.verifyTrafficConnection();

        return tApiStatus;
    }   

    public static boolean checkGPSConnection() {
        boolean gpsStatus = false;

        gpsStatus = gpsFeed.verifyGPSConnection();

        return gpsStatus;
    }

    
    public static double requestTrafficDensity() {
        double tDensity = 0.0;

        tDensity = trafficAPI.getTrafficDensity();

        return tDensity;
    }

    public static gpsCoords requestPosition() {
        gpsCoords currPos;

        currPos = gpsFeed.getCurrPosition();

        return currPos;
    }

    public static double calculateETA(double tDensity, gpsCoords currPos, gpsCoords endPos) {
        //Implement method to estimate ETA with traffic and postion data

        return 0.0;
    }
}