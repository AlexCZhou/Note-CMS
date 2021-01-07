# Simple
> 感谢younghz的[中文markdown教程](https://github.com/younghz/Markdown)，这里测试网站markdown格式就随手从他那儿拿一点来测试了。
## 标题
### 使用#
```
## 2
### 3
#### 4
##### 5
###### 6
```
效果：
## 2
### 3
#### 4
##### 5
###### 6

### 使用=和-
```
一级标题
=========
二级标题
---------
```
效果：
一级标题
=========
二级标题
---------

## 引用
```
> 区块引用
>> 嵌套引用
```
> 区块引用
>> 嵌套引用

## 代码区块
### 使用制表符
效果：

    void main()
    {
        printf("Use tab or 4 spaces");
    }

### 使用```
效果：
```
void main()
{
    printf("use```");
}
```
### `符号
`printf("Hello world!");`

## 强调
*斜体*，_斜体_  
**粗体**，__粗体__  
~~被划掉~~  
  
## 列表
### 使用 -
- 第一项 
- 第二项 
- 第三项
### 使用 *
* 第一项
* 第二项
* 第三项
### 使用 +
+ (+) 第一项
+ (+) 第二项
+ (+) 第三项
### 使用数字和.组合
_ _ _
1. 第一项
2. 第二项
3. 第三项

## 分割线
使用`- - -`
- - -
使用`* * *`
* * *
使用`_ _ _`
_ _ _
分割线测试完毕

## 链接
### 行内式链接
```
[younghz的Markdown库](https://github.com/younghz/Markdown "Markdown")。
```
效果：
[younghz的Markdown库](https://github.com/younghz/Markdown "Markdown")。
### 参考式链接
```
[younghz的Markdown库1][1]
[younghz的Markdown库2][2]

[1]:https://github.com/younghz/Markdown "Markdown"
[2]:https://github.com/younghz/Markdown "Markdown"
```
效果：
[younghz的Markdown库1][1]
[younghz的Markdown库2][2]

[1]:https://github.com/younghz/Markdown "Markdown"
[2]:https://github.com/younghz/Markdown "Markdown"

## 图片
```
![logo](Avatar.jpg "logo")
```
![logo](Avatar.jpg "logo")


## 表格(非传统Markdown)
```
|代码库|链接|
|:-:|-|
|MarkDown|[https://github.com/younghz/Markdown](https://github.com/younghz/Markdown "Markdown")|
|MarkDownCopy|[https://github.com/younghz/Markdown](https://github.com/younghz/Markdown "Markdown")|
```

|代码库|链接|
|:-:|-|
|MarkDown|[https://github.com/younghz/Markdown](https://github.com/younghz/Markdown "Markdown")|
|MarkDownCopy|[https://github.com/younghz/Markdown](https://github.com/younghz/Markdown "Markdown")|
