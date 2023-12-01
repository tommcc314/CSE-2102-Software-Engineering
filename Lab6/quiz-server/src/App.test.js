import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import Home from './app.js';
import Nav from './components/nav.js';
import Quiz from './components/quiz.js';
import Signup from './components/signup.js';
test('Home page renders', () => {
  render(<Home />);
  const linkElement = screen.getByText(/Welcome to 2102 Quizzes!/i);
  expect(linkElement).toBeInTheDocument();
});
test('Nav renders', () => {
  render(<Nav />);
  const linkElement = screen.getByText(/New Quiz/i);
  expect(linkElement).toBeInTheDocument();
});
test('Quiz page renders', () => {
  render(<Quiz />);
  const linkElement = screen.getByText(/Submit/i);
  expect(linkElement).toBeInTheDocument();
});
test('Signup page renders', () => {
  render(<Signup />);
  const linkElement = screen.getByText(/Email/i);
  expect(linkElement).toBeInTheDocument();
});
