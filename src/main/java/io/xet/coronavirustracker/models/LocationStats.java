package io.xet.coronavirustracker.models;

public class LocationStats {
    private String state;
    private String country;
    private String latestReportedCases;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestReportedCases='" + latestReportedCases + '\'' +
                '}';
    }

    public String getLatestReportedCases() {
        return latestReportedCases;
    }

    public void setLatestReportedCases(String latestReportedCases) {
        this.latestReportedCases = latestReportedCases;
    }
}
