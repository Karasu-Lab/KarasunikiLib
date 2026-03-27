package net.karasuniki.karasunikilib.api.client.model.animation;

import net.karasuniki.karasunikilib.api.data.INbtData;
import net.karasuniki.karasunikilib.api.data.INbtReadable;
import net.karasuniki.karasunikilib.api.data.INbtWritable;

public interface IAnimSpeed extends INbtReadable, INbtWritable, INbtData {
    float getSpeed();

    void setSpeed(float speed);
}
