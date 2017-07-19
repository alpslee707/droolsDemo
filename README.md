# droolsDemo

drools规则演示。


需要工具： 1.jdk1.6+

2.maven

3.eclipse

需要时间： 项目搭建时间10分钟+

入门
DRL规则文件在when之前可以设置的属性如下所示：

no-loop：在DRL的then子句中，如果出现insert、update、modify、retract等方法对实例（Fact）做出修改时，当前规则执行完成后会触发该规则使其再执行一次；将no-loop设置为true则会强制规则在出现上述方法的情况下也只执行一次
boolean型，默认值为false

ruleflow-group：基于ruleflow将规则分组
string型，无默认值

lock-on-active：规则可能会被其它规则调用而反复执行；将lock-on-active置为true可以强制使规则在任何条件下都只会执行一次，可视为no-loop的加强版
boolean型，默认值为false

salience：设置当前这条规则的执行优先级，数字越小优先级越高
int型，默认值为0

agenda-group：基于Agenda将规则分组；只有当某个Agenda组获取到焦点（focus）时，该组的规则才会被执行
string型，默认值为MAIN

auto-focus：与agenda-group配合使用，设置焦点的是否可以自动获取
boolean型，默认值为false

activation-group：不基于任何条件将规则分组
string型，无默认值

dialect：设置规则所使用的语言
string型，默认值根据package值判断，值域为java或mvel

data-effective：当前规则的生效时间
string型，无默认值；值中需包含日期和时间

data-expires：当前规则的失效时间
string型，无默认值；值中需包含日期和时间

duration：设置DRL文件开始执行之后延迟多长时间开始执行这条规则
long型，无默认值

