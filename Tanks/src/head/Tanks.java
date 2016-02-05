package head;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class Tanks {
	private String version = "0.000";
	private Shell shell;
	private int botCount = 5;
	
	public static void main(String[] args) {
		Display display = new Display();
		Tanks application = new Tanks();
		Shell shell = application.open(display);
		while(!shell.isDisposed()){
			if(!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	
	private Shell open(Display display) {
		shell = new Shell(display);
		shell.setText("Танчики (версия "+version+")");
		installMenu();
		shell.open();
		return shell;
	}
	
	 private void installMenu(){
		Menu menuBar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menuBar);
		 add1Menu(menuBar);
		 add2Menu(menuBar);
	 }

	private void add1Menu(Menu menuBar){
		MenuItem item = new MenuItem(menuBar, SWT.CASCADE);
		item.setText("Игра");
		Menu menu = new Menu(shell, SWT.DROP_DOWN);
		item.setMenu(menu);
		
		MenuItem subItem;
		
		subItem = new MenuItem(menu, SWT.NONE);
		subItem.setText("&Начать игру заново	R");
		subItem.setEnabled(false);
		subItem.setAccelerator('R');
		subItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Restart
			}
			
		});		

		
		subItem = new MenuItem(menu, SWT.NONE);
		subItem.setText("Начать новую игру");
		subItem.setEnabled(false);
		subItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Restart
			}
		});		
		
		new MenuItem(menu, SWT.SEPARATOR);
		
		subItem = new MenuItem(menu, SWT.CHECK);
		subItem.setText("&Пауза	P");
		subItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Пауза
			}
		});		
		subItem.setAccelerator('P');
		
		new MenuItem(menu, SWT.SEPARATOR);
		
		subItem = new MenuItem(menu, SWT.NONE);
		subItem.setText("Выход");
		subItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});


	 }
	private void add2Menu(Menu menuBar){
		MenuItem item = new MenuItem(menuBar, SWT.CASCADE);
		item.setText("Настройки");
		Menu menu = new Menu(shell, SWT.DROP_DOWN);
		item.setMenu(menu);
		MenuItem subItem;
		
		menu.addMenuListener(new MenuAdapter() {
			@Override
			public void menuShown(MenuEvent e) {
				Menu menu = (Menu)e.widget;
				MenuItem[] items = menu.getItems();
				items[1].setText("Число соперников: "+botCount);
			}
		});
		
		subItem = new MenuItem(menu, SWT.NONE);
		subItem.setText("&Добавить соперника	+");
		subItem.setAccelerator('+');
		subItem.setAccelerator(SWT.KEYPAD_ADD);
		subItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (botCount<20) botCount++;
			}
			
		});		

		subItem = new MenuItem(menu, SWT.NONE);
		
		subItem = new MenuItem(menu, SWT.NONE);
		subItem.setText("&Убавить оперника	-");
		subItem.setAccelerator('-');
		subItem.setAccelerator(SWT.KEYPAD_SUBTRACT);
		subItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (botCount > 1) botCount--;
			}
		});		
		


	 }
	
	
	
	
	
}


