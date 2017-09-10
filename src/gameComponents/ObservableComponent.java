package gameComponents;

import java.util.ArrayList;

public abstract class ObservableComponent
{
    private ArrayList<ComponentObserver> allObserver;

    protected ObservableComponent()
    {
        allObserver = new ArrayList<>();
    }

    protected void addObserver(ComponentObserver newObserver)
    {
        allObserver.add(newObserver);
    }

    public void notifyChanges()
    {
        for (ComponentObserver componentObserver : allObserver)
        {
            componentObserver.update();
        }
    }
}
