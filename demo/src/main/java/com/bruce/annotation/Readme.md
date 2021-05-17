# 自定义注解
## 注意
- 当开发者使用了Annotation 修饰了类、方法、Field 等成员之后，这些 Annotation 不会自己生效，
必须由开发者提供相应的代码来提取并处理 Annotation 信息。
这些处理提取和处理 Annotation 的代码统称为 APT（Annotation Processing Tool)。

- 注解的提取需要借助于 Java 的反射技术，反射比较慢，所以注解使用时也需要谨慎计较时间成本。