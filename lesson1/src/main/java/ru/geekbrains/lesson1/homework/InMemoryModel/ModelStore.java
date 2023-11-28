package ru.geekbrains.lesson1.homework.InMemoryModel;

import ru.geekbrains.lesson1.homework.ModelElements.PoligonalModel;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Хранилище 3D-элементов
 * TODO: Доработать самостоятельно в рамках домашней работы
 */
public class ModelStore implements ModelChanger {
    ArrayList<PoligonalModel> Models = new ArrayList<>();
    ArrayList<Scene> Scenes = new ArrayList<>();
    ArrayList<Flash> Flashes = new ArrayList<>();
    ArrayList<Camera> Cameras = new ArrayList<>();

    private Collection<ModelChangedObserver> observers = new ArrayList<>();

    @Override
    public void registerModelChanger(ModelChangedObserver o) {
        observers.add(o);
    }

    @Override
    public void removeModelChanger(ModelChangedObserver o) {
        observers.remove(o);
    }

    /**
     * Нотификация изменений на уровне хранилища
     */
    private void notifyChange(){
        for (ModelChangedObserver observer : observers){
            observer.applyUpdateModel();
        }
    }

    public void addModel(PoligonalModel poligonalModel){
        notifyChange();
    }


    @Override
    public void ApplyUpdateModel() {
        // TODO Auto-generated method stub

    }
    public Scene getScene(int n_scene) {

        return Scenes.get(n_scene);
    }
}
