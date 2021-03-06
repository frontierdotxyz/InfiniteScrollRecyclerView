# InfiniteScrollRecyclerView

**Pros:**

1. Simple plug and play custom RecyclerView.
2. Easy to use 
3. Built on top of RecyclerView, hence it is performant as it works on the typical adapters and layout managers.

**Credits:**

This view is inspired from iOS App store trending animation.


![Appstore-video](https://user-images.githubusercontent.com/73110189/139418008-bf6838f3-c9ce-4959-be99-077c8568b848.gif)


## Usage

**In XML: (Grid)**

```
    <com.frontier.infinitescrollrecyclerview.view.InfiniteAutoScrollRecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:scrollLayoutType="grid" />
```
https://user-images.githubusercontent.com/73110189/139422808-453ac103-0939-4204-9a42-43050b57d26c.mp4


**In XML: (List)**

```
    <com.frontier.infinitescrollrecyclerview.view.InfiniteAutoScrollRecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:scrollLayoutType="list" />
```

https://user-images.githubusercontent.com/73110189/139424788-c2fdfbdc-e1d5-439c-8723-c0492f9d89b0.mp4

**In Activity or Fragment:**

Simple :-)

Just call

```
recyclerView.startScrolling("YOUR_DRAWABLE_ARRAY")
```    

**Apps using InfiniteScrollRecyclerView**

https://user-images.githubusercontent.com/73110189/139619108-2f6c8f1d-711f-43d8-9ba6-bbe47cee7614.mp4

Google play store link: https://play.google.com/store/apps/details?id=com.frontierwallet



