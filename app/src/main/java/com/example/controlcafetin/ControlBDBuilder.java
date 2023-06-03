package com.example.controlcafetin;

import android.content.Context;

public class ControlBDBuilder {
    private Context ctx;
    private Context context;

    public ControlBDBuilder setCtx(Context ctx) {
        this.ctx = ctx;
        return this;
    }

    public ControlBDBuilder setContext(Context context) {
        this.context = context;
        return this;
    }

    public ControlBD createControlBD() {
        return new ControlBD(ctx);
    }
}