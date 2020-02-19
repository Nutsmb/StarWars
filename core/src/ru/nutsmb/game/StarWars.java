package ru.nutsmb.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;

import ru.nutsmb.game.screen.MenuScreen;

public class StarWars extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen());
	}
}
