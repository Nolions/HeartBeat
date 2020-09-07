# HeartBeat

heart beat animation

## Use

1. Add flow on xml layout

```
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    ...

    <tw.nolions.heartbeat.HeartBeatSwitchCompat
        android:id="@+id/heartBeat"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:backgroundTint="#FF0000"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    ...

</androidx.constraintlayout.widget.ConstraintLayout>

```

2. animation

strat

```
heartBeat.start()
```

stop 

```
heartBeat.stop()
```

or Toggle

```
heartBeat.animationToggle()
```


## Reference

1. https://github.com/scottyab/HeartBeatView
2. https://blog.stylingandroid.com/animatedicons-heart/