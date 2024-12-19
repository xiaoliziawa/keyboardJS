# KeyBaordJS

## 在 Server 监听按键按下释放操作

KeyPressed

```js
ItemEvents.rightClicked("emerald", (event) => {
	event.player.tell(Keyboard.pressed(Keys.F3));
});
```

KeyReleased

```js
PlayerEvents.tick((event) => {
	event.player.tell(Keyboard.released(Keys.X));
});
```