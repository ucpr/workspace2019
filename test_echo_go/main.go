package main

import (
	"fmt"
	"net/http"

	echotemplate "github.com/foolin/echo-template"
	"github.com/labstack/echo"
)

func get_handler(c echo.Context) (err error) {
	return c.Render(http.StatusOK, "index.html", nil)
}

func post_handler(c echo.Context) (err error) {
	fmt.Println(c.Request().PostFormValue("submit"))
	return c.String(http.StatusOK, "SUBMIT")
}

func main() {
	e := echo.New()

	e.Renderer = echotemplate.Default()

	e.GET("/", func(c echo.Context) error {
		return c.Render(http.StatusOK, "index.html", nil)
	})
	e.POST("/", post_handler)

	e.Logger.Fatal(e.Start(":8080"))
}
