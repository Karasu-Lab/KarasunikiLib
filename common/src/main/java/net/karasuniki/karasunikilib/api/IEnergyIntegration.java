package net.karasuniki.karasunikilib.api;

public interface IEnergyIntegration extends IModIntegration {
    double getToAbyssRate();

    default double getFromAbyssRate() {
        return 1.0 / getToAbyssRate();
    }
}
