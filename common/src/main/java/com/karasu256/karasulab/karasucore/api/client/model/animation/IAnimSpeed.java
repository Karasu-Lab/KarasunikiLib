package com.karasu256.karasulab.karasucore.api.client.model.animation;

import com.karasu256.karasulab.karasucore.api.data.INbtData;
import com.karasu256.karasulab.karasucore.api.data.INbtReadable;
import com.karasu256.karasulab.karasucore.api.data.INbtWritable;

public interface IAnimSpeed extends INbtReadable, INbtWritable, INbtData {
    float getSpeed();

    void setSpeed(float speed);
}
