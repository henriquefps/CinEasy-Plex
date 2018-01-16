package programa;


import controladores.ScreenManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage) {
		try {
			ScreenManager.getInstance().setMainStage(primaryStage);
			ScreenManager.getMainStage().setTitle("Cine EasyPlex");
			ScreenManager.getMainStage().setResizable(false);
			ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuPrincipal());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
			launch(args);
		
	}
}
