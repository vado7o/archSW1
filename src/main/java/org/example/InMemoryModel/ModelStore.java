package org.example.InMemoryModel;


import org.example.ModelElements.Camera;
import org.example.ModelElements.Flash;
import org.example.ModelElements.PoligonalModel;
import org.example.ModelElements.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger {
    public List<PoligonalModel> models;
    public List<Scene> scenes;
    public List<Flash> flashes;
    public List<Camera> cameras;
    private List<IModelChangedObserver> changedObservers;

    public ModelStore(List<IModelChangedObserver> changedObservers) throws Exception {
        this.changedObservers = changedObservers;
        this.models = new ArrayList<>();
        this.scenes = new ArrayList<>();
        this.flashes = new ArrayList<>();
        this.cameras = new ArrayList<>();

        models.add(new PoligonalModel(null));
        flashes.add(new Flash());
        cameras.add(new Camera());
        scenes.add(new Scene(0, models, flashes, cameras));
    }
    public Scene getScene(int j) {
        for (int i = 0; i < scenes.size(); i++) {
            if (scenes.get(i).id == j) {
                return scenes.get(i);
            }
        }
        return null;
    }

    @Override
    public void NotifyChange(IModelChanger sender) {

    }
}
