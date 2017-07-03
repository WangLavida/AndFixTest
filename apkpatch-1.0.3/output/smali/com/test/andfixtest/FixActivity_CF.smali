.class public Lcom/test/andfixtest/FixActivity_CF;
.super Landroid/support/v7/app/AppCompatActivity;
.source "FixActivity.java"


# instance fields
.field private textView:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    return-void
.end method

.method private init()V
    .locals 2
    .annotation runtime Lcom/alipay/euler/andfix/annotation/MethodReplace;
        clazz = "com.test.andfixtest.FixActivity"
        method = "init"
    .end annotation

    .prologue
    .line 24
    iget-object v0, p0, Lcom/test/andfixtest/FixActivity_CF;->textView:Landroid/widget/TextView;

    const-string v1, "\u8fd9\u662f\u4fee\u590d\u5b8c\u6210\u7684,666"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 25
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 16
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 17
    const v0, 0x7f04001a

    invoke-virtual {p0, v0}, Lcom/test/andfixtest/FixActivity_CF;->setContentView(I)V

    .line 18
    const v0, 0x7f0c0077

    invoke-virtual {p0, v0}, Lcom/test/andfixtest/FixActivity_CF;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/test/andfixtest/FixActivity_CF;->textView:Landroid/widget/TextView;

    .line 19
    invoke-direct {p0}, Lcom/test/andfixtest/FixActivity_CF;->init()V

    .line 20
    return-void
.end method
