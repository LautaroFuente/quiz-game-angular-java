import { Question } from "./Question.interface";

export interface Answer {
    description: string;
    correct: boolean;
    question: Question;
  }