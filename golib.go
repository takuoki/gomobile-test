package golib

import (
	"errors"
)

// Golib is an interface for go library
type Golib interface {
	Foo(msg string) (string, error)
}

type golib struct {}

// NewClient returns an instance of GomoPoster
func NewClient() Golib {
	return &golib{}
}

func (g *golib) Foo(msg string) (string, error) {
	if msg == "error" {
		return "", errors.New("this is golang error")
	}
	return "Hi! this is golang! your message is " + msg, nil
}