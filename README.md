# InfiniteScrollRecyclerView

Pros:

1. Simple plug and play custom RecyclerView.
2. Easy to use 
3. Built on top of RecyclerView, hence it is performant as it works on the typical adapters and layout managers.

This view is inspired from iOS App store trending animation.


![Appstore-video](https://user-images.githubusercontent.com/73110189/139418008-bf6838f3-c9ce-4959-be99-077c8568b848.gif)


## Usage

**In XML: (Grid)**

```
    <com.frontier.infinitescrollrecyclerview.view.InfiniteAutoScrollRecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        app:scrollLayoutType="grid" />
```
https://user-images.githubusercontent.com/73110189/139422808-453ac103-0939-4204-9a42-43050b57d26c.mp4


**In XML: (List)**

```
    <com.frontier.infinitescrollrecyclerview.view.InfiniteAutoScrollRecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        app:scrollLayoutType="list" />
```

https://user-images.githubusercontent.com/73110189/139424788-c2fdfbdc-e1d5-439c-8723-c0492f9d89b0.mp4

**In Activity or Fragment:**

Simple :-)

Just call

```
recyclerView.startScrolling("YOUR_DRAWABLE_ARRAY")
```    






