package comp3170.week5;

import java.util.ArrayList;

import org.joml.Matrix4f;
import org.joml.Vector4f;
import comp3170.InputManager;
import comp3170.SceneObject;

import comp3170.week5.sceneobjects.*;

public class Scene extends SceneObject {
	private Camera camera;
	
	private SceneObject root;
	
	private ArrayList<Flower> flowers = new ArrayList<Flower>();
	
	public Scene() {
		// Scene
		root = this;
		
		// Camera
		camera = new Camera();
		camera.setParent(root);
		
		//Flower
		createFlower(new Vector4f(0.0f, 0.0f,0.f,1.0f));			
	}
	
	public Camera sceneCam() {
		return camera;
	}
	
	public void createFlower(Vector4f position) {
		Flower flower = new Flower(10);
		flower.setParent(root);	
		flower.getMatrix().translate(position.x,position.y,0.0f).rotateZ((float)-(15*Math.PI/180));
		flowers.add(flower);
	}

	public void update(InputManager input, float dt) {
		
		camera.update(input, dt);
		
		for(int i = 0; i < flowers.size(); i++) {
			flowers.get(i).update(dt);
		}
		// TODO: Update the flowers when animating them. (TASK 5)
	}
	
}
