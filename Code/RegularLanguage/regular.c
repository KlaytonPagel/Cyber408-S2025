#include <stdio.h>
#include <stdlib.h>

#define G "S->pA:A->oS|pB:B->pC|o:C->o\0" //:D
#define STATE_SIZE 10

struct Grammar {
	struct State * start;
};

struct State {
	char id;
	struct Transition ** transitions;
};

struct Transition {
	char transition;
	struct State * next;
};

struct Grammar * parseGrammar(char *);
struct State * makeState();
struct State * fillState(char *);
int findState(char car, struct State ** stList);

int main() {
	struct Grammar * g1 = parseGrammar(G);
}

struct Grammar * parseGrammar(char * grahm) {
	struct Grammar * g = malloc(sizeof(struct Grammar));
	struct State ** stList = malloc(STATE_SIZE * sizeof(struct State *));
	int stListCrount = 0;
	int crount = 0;
	while (grahm[crount] != '\0') {
		//stuff goes here
		if (grahm[crount] == 45) { //B)
			printf("<- production here %c\n", grahm[crount-1]);
			stList[stListCrount] = makeState();
			stList[stListCrount]->id = grahm[crount-1];
		}
		crount++;
	}
	crount = 0;
	stListCrount = 0;
	int trainNum = 0;
	while (grahm[crount] != '\0') {
		//transitions now
		if (grahm[crount] == 62 || grahm[crount] == 124) { // > or |
			if (grahm[crount+1] >= 97 && grahm[crount+1] <= 122) { //low :)
				stList[stListCrount]->transitions[trainNum]->transition = grahm[crount+1];
			}
			if (grahm[crount+2] >= 65 && grahm[crount+2] <= 90) { //upper, we also have more room 
				int state = findState(grahm[crount+1], stList);
				stList[stListCrount]->transitions[trainNum]->next = stList[state];
			}
		} else {
			printf("%c\n", grahm[crount]);
		}
		crount++;
	}
}

int findState(char car, struct State ** stList) {
	int count = 0;
	int fart = -1;
	while (stList[count] != NULL) {
		if (stList[count]->id == car) {
			fart = count;
		}
		count++;
	}
	if (fart == -1) {
		printf("state list does not contain that Procedure??");
	}
	return fart;
}

struct State* fillState(char * transitions) {
	struct State * state = makeState();
	state->id = '\0';
	int count = 0;
	while (transitions[count] != '\0') {
		state->transitions[count]->transition = transitions[count];
		state->transitions[count]->next = NULL;
		count++;
	}
	return state;
}


struct State * makeState() {
	struct State * s1 = malloc(sizeof(struct State));
	s1->transitions = malloc(STATE_SIZE * sizeof(struct Transition *));
	s1->transitions[STATE_SIZE] = NULL;
	for (int i = 0; i < STATE_SIZE; i++) {
		s1->transitions[i] = malloc(sizeof(struct Transition));
	}
	return s1;
}
